package com.backbase.ct.dataloader.clients.transaction;

import com.backbase.ct.dataloader.clients.common.AbstractRestClient;
import com.backbase.ct.dataloader.data.CommonConstants;
import com.backbase.integration.transaction.external.rest.spec.v2.transactions.TransactionsPostRequestBody;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class TransactionsIntegrationRestClient extends AbstractRestClient {

    private static final String TRANSACTIONS = globalProperties.getString(CommonConstants.PROPERTY_TRANSACTIONS_BASE_URI);
    private static final String SERVICE_VERSION = "v2";
    private static final String TRANSACTION_INTEGRATION_SERVICE = "transaction-integration-service";
    private static final String ENDPOINT_TRANSACTIONS = "/transactions";

    public TransactionsIntegrationRestClient() {
        super(TRANSACTIONS, SERVICE_VERSION);
        setInitialPath(composeInitialPath());
    }

    public Response ingestTransaction(TransactionsPostRequestBody body) {
        return requestSpec()
            .contentType(ContentType.JSON)
            .body(body)
            .post(getPath(ENDPOINT_TRANSACTIONS));
    }

    @Override
    protected String composeInitialPath() {
        return TRANSACTION_INTEGRATION_SERVICE;
    }

}